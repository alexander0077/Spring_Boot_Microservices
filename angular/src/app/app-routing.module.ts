import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {TeamListComponent} from "./team/view/team-list/team-list.component";
import {TeamNewComponent} from "./team/view/team-new/team-new.component";
import {TeamEditComponent} from "./team/view/team-edit/team-edit.component";
import {TeamViewComponent} from "./team/view/team-view/team-view.component";
import {PlayerAddComponent} from "./player/view/player-add/player-add.component";
import {PlayerEditComponent} from "./player/view/player-edit/player-edit.component";
import {PlayerViewComponent} from "./player/view/player-view/player-view.component";

const routes: Routes = [
  {
  component: TeamListComponent,
  path: "teams"
  },
  {
    component: TeamNewComponent,
    path: "teams/new"
  },
  {
    component: TeamEditComponent,
    path: "teams/:uuid/edit"
  },
  {
    component: TeamViewComponent,
    path: "teams/:uuid"
  },
  {
    component: PlayerAddComponent,
    path: "teams/:uuid/player/new"
  },
  {
    component: PlayerEditComponent,
    path: "teams/:teams_uuid/player/:players_uuid/edit"
  },
  {
    component: PlayerViewComponent,
    path: "teams/:teams_uuid/player/:players_uuid"
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {

}
