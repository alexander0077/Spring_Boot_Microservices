import {Component, OnInit} from '@angular/core';
import { Teams } from '../../model/teams';
import {TeamService} from "../../service/team.service";
import {Team} from "../../model/team";

@Component({
  selector: 'app-team-list',
  templateUrl: './team-list.component.html',
  styleUrls: ['./team-list.component.css']
})
export class TeamListComponent implements OnInit {
  constructor(private service: TeamService) {
  }

  teams: Teams | undefined;

  ngOnInit(): void {
    this.service.getTeams().subscribe(teams => this.teams = teams);
  }


  onDelete(team: Team): void {
    this.service.deleteTeam(team.id).subscribe(() => this.ngOnInit());
  }

}
