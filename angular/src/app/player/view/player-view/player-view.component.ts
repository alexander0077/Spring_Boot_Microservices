import { Component } from '@angular/core';
import {TeamService} from "../../../team/service/team.service";
import {PlayerService} from "../../service/player.service";
import {ActivatedRoute} from "@angular/router";
import {TeamForm} from "../../../team/model/team-form";
import {Players} from "../../model/players";
import {Player} from "../../model/player";
import {PlayerForm} from "../../model/player-form";

@Component({
  selector: 'app-player-view',
  templateUrl: './player-view.component.html',
  styleUrls: ['./player-view.component.css']
})
export class PlayerViewComponent {
  constructor(private player_service: PlayerService, private route: ActivatedRoute) {
  }

  player: PlayerForm | undefined;

  ngOnInit(): void {
    this.route.params.subscribe(params => {
      this.player_service.getPlayer(params['players_uuid'])
        .subscribe(team => {
          this.player = {
            name: team.name,
            shirt_number: team.shirt_number,
            team: params['teams_uuid']
          };
        });
    });
  }
}
