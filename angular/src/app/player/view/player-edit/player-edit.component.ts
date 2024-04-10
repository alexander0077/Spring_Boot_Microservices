import { Component } from '@angular/core';
import {TeamForm} from "../../../team/model/team-form";
import {TeamService} from "../../../team/service/team.service";
import {ActivatedRoute, Router} from "@angular/router";
import {PlayerForm} from "../../model/player-form";
import {PlayerService} from "../../service/player.service";
import {Teams} from "../../../team/model/teams";

@Component({
  selector: 'app-player-edit',
  templateUrl: './player-edit.component.html',
  styleUrls: ['./player-edit.component.css']
})
export class PlayerEditComponent {
  uuid: string | undefined;
  player: PlayerForm | undefined;
  original: PlayerForm | undefined;

  constructor(
    private playerService: PlayerService,
    private route: ActivatedRoute,
    private router: Router
  ) {
  }

  ngOnInit() {
    this.route.params.subscribe(params => {
      this.playerService.getPlayer(params['players_uuid'])
        .subscribe(player => {
          this.uuid = params['players_uuid'];
          this.player = {
            name: player.name,
            shirt_number: player.shirt_number,
            team: params['teams_uuid']
          };
          this.original = {...this.player};
        });
    });
  }

  onSubmit(): void {
    this.playerService.putPlayer(this.uuid!, this.player!)
      .subscribe(() => this.router.navigate(['/teams/', this.player?.team]));
  }
}
