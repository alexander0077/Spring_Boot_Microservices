import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Teams} from "../../team/model/teams";
import {Players} from "../model/players";
import {TeamForm} from "../../team/model/team-form";
import {PlayerForm} from "../model/player-form";
import {Player} from "../model/player";

@Injectable({
  providedIn: 'root'
})
export class PlayerService {

  constructor(private http: HttpClient) { }

  getPlayers(): Observable<Players> {
    return this.http.get<Players>('/api/players');
  }

  getPlayer(uuid: string): Observable<Player> {
    return this.http.get<Player>('/api/players/' + uuid);
  }

  getTeamsPlayers(uuid: string): Observable<Players> {
    return this.http.get<Players>('/api/teams/' + uuid + "/players");
  }

  deletePlayer(uuid: string): Observable<any> {
    return this.http.delete('/api/players/' + uuid);
  }

  putPlayer(uuid: string, request: PlayerForm): Observable<any> {
    return this.http.put('/api/players/' + uuid, request);
  }
}
