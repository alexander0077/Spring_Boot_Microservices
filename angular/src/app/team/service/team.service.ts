import { Injectable } from '@angular/core';
import { HttpClient } from "@angular/common/http";
import { Observable } from "rxjs";
import { Teams } from "../model/teams";
import {TeamForm} from "../model/team-form";
import {Team} from "../model/team";
import {TeamDetails} from "../model/team-details";

@Injectable({
  providedIn: 'root',
})
export class TeamService {

  constructor(private http: HttpClient) {

  }

  getTeams(): Observable<Teams> {
    return this.http.get<Teams>('/api/teams');
  }

  getTeam(uuid: string): Observable<TeamDetails> {
    return this.http.get<TeamDetails>('/api/teams/' + uuid);
  }

  deleteTeam(uuid: string): Observable<any> {
    return this.http.delete('/api/teams/' + uuid);
  }

  putTeam(uuid: string, request: TeamForm): Observable<any> {
    return this.http.put('/api/teams/' + uuid, request);
  }


}
