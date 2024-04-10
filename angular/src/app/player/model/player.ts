import {Team} from "../../team/model/team";

export interface Player {
  id: string;
  name: string;
  shirt_number: number
  team: Team
}
