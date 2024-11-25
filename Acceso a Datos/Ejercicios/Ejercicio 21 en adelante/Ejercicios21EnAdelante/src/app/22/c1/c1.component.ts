import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { C2Component } from "../c2/c2.component";

@Component({
  selector: 'app-c1',
  standalone: true,
  imports: [FormsModule, C2Component],
  templateUrl: './c1.component.html',
  styleUrl: './c1.component.css'
})
export class C1Component {

  title: string = 'C1';
  numeroActual! : number;
}
