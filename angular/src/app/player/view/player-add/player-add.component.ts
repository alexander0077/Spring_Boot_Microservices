import { Component } from '@angular/core';
import {TeamForm} from "../../../team/model/team-form";
import {TeamService} from "../../../team/service/team.service";
import {ActivatedRoute, Router} from "@angular/router";
import {v4 as uuidv4} from "uuid";
import {PlayerForm} from "../../model/player-form";
import {Team} from "../../../team/model/team";
import {Player} from "../../model/player";
import {PlayerService} from "../../service/player.service";

@Component({
  selector: 'app-player-add',
  templateUrl: './player-add.component.html',
  styleUrls: ['./player-add.component.css']
})
export class PlayerAddComponent {
  uuid: string | undefined;
  player_name: string = "";
  player_shirt_number: number = 0;
  players_team_id: string = "";

  player: PlayerForm = {
    name : this.player_name,
    shirt_number : this.player_shirt_number,
    team: this.players_team_id
  };
  constructor(private playerService: PlayerService,
              private route: ActivatedRoute,
              private router: Router
  ) {
  }
  onSubmit(): void {
    this.route.params.subscribe(params => {
      this.player = {
        name : this.player_name,
        shirt_number : this.player_shirt_number,
        team : params['uuid']
      };
    });
    this.uuid = uuidv4();
    this.playerService.putPlayer(this.uuid!, this.player!)
      .subscribe(() => this.router.navigate(['/teams/' + this.player.team]));
  }
}

