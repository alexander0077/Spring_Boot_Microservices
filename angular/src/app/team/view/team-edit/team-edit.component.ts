import {Component, OnInit} from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";
import {TeamForm} from "../../model/team-form";
import {TeamService} from "../../service/team.service";

@Component({
  selector: 'app-team-edit',
  templateUrl: './team-edit.component.html',
  styleUrls: ['./team-edit.component.css']
})
export class TeamEditComponent implements OnInit{

  uuid: string | undefined;
  team: TeamForm | undefined;
  original: TeamForm | undefined;

  constructor(
    private teamService: TeamService,
    private route: ActivatedRoute,
    private router: Router
  ) {
  }

  ngOnInit() {
    this.route.params.subscribe(params => {
      this.teamService.getTeam(params['uuid'])
        .subscribe(team => {
          this.uuid = params['uuid'];
          this.team = {
            name: team.name,
            budget: team.budget
          };
          this.original = {...this.team};
        });
    });
  }

  onSubmit(): void {
    this.teamService.putTeam(this.uuid!, this.team!)
      .subscribe(() => this.router.navigate(['/teams']));
  }

}
