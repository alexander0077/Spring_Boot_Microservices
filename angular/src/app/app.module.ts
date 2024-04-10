import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { MainComponent } from './component/main/main.component';
import { NavComponent } from './component/nav/nav.component';
import { HttpClientModule } from "@angular/common/http";
import { FooterComponent } from './component/footer/footer.component';
import { HeaderComponent } from './component/header/header.component';
import { TeamListComponent } from './team/view/team-list/team-list.component';
import { TeamService } from "./team/service/team.service";
import { TeamNewComponent } from './team/view/team-new/team-new.component';
import {FormsModule} from "@angular/forms";
import { TeamEditComponent } from './team/view/team-edit/team-edit.component';
import { TeamViewComponent } from './team/view/team-view/team-view.component';
import { PlayerAddComponent } from './player/view/player-add/player-add.component';
import { PlayerEditComponent } from './player/view/player-edit/player-edit.component';
import { PlayerViewComponent } from './player/view/player-view/player-view.component';

@NgModule({
  declarations: [
    AppComponent,
    MainComponent,
    NavComponent,
    FooterComponent,
    HeaderComponent,
    TeamListComponent,
    TeamNewComponent,
    TeamEditComponent,
    TeamViewComponent,
    PlayerAddComponent,
    PlayerEditComponent,
    PlayerViewComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [TeamService],
  bootstrap: [AppComponent]
})
export class AppModule { }
