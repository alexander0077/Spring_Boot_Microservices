import {Component, OnInit} from '@angular/core';
import {TeamService} from "../../service/team.service";
import {Teams} from "../../model/teams";
import {Player} from "../../../player/model/player";
import {PlayerService} from "../../../player/service/player.service";
import {Team} from "../../model/team";
import {Players} from "../../../player/model/players";
import {ActivatedRoute} from "@angular/router";
import {TeamForm} from "../../model/team-form";

@Component({
  selector: 'app-team-view',
  templateUrl: './team-view.component.html',
  styleUrls: ['./team-view.component.css']
})
export class TeamViewComponent implements OnInit{

  constructor(private team_service: TeamService, private player_service: PlayerService, private route: ActivatedRoute) {
  }

  team_uuid: string | undefined;
  team: TeamForm | undefined;
  players: Players | undefined;


  ngOnInit(): void {
    this.route.params.subscribe(params => {
      this.team_service.getTeam(params['uuid'])
        .subscribe(team => {
          this.team_uuid = params['uuid'];
          this.team = {
            name: team.name,
            budget: team.budget
          };
          this.player_service.getTeamsPlayers(params['uuid'])
            .subscribe(players => this.players = players);
        });
    });
  }

  onDelete(player: Player): void {
    this.player_service.deletePlayer(player.id).subscribe(() => this.ngOnInit());
  }
}
