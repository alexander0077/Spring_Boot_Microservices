import { Component } from '@angular/core';
import {TeamForm} from "../../model/team-form";
import {ActivatedRoute, Router} from "@angular/router";
import {TeamService} from "../../service/team.service";
import {v4 as uuidv4} from 'uuid';

@Component({
  selector: 'app-team-new',
  templateUrl: './team-new.component.html',
  styleUrls: ['./team-new.component.css']
})
export class TeamNewComponent {
  uuid: string | undefined;
  team_name: string = "";
  team_budget: number = 0;
  team: TeamForm = {
    name : this.team_name,
    budget : this.team_budget
  };
  constructor(private teamService: TeamService,
              private route: ActivatedRoute,
              private router: Router
  ) {
  }

  onSubmit(): void {
    this.uuid = uuidv4();
    this.team = {
      name : this.team_name,
      budget : this.team_budget
    };

    this.teamService.putTeam(this.uuid!, this.team!)
      .subscribe(() => this.router.navigate(['/teams']));
  }

}
