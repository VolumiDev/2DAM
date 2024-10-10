import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { Ejer10Component } from './ejer10/ejer10.component';
import { Ejer11Component } from './ejer11/ejer11.component';
import { Ejer12Component } from './ejer12/ejer12.component';
import { Ejer9Component } from './ejer9/ejer9.component';
import { Ejer8Component } from './ejer8/ejer8.component';
import { Ejer7Component } from './ejer7/ejer7.component';
import { Ejer6Component } from './ejer6/ejer6.component';
import { Ejer5Component } from './ejer5/ejer5.component';
import { Ejer13Component } from './ejer13/ejer13.component';
import { Ejer14Component } from './ejer14/ejer14.component';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet,Ejer5Component, Ejer6Component,Ejer7Component, Ejer8Component, Ejer9Component,
     Ejer10Component, Ejer11Component, Ejer12Component, Ejer13Component, Ejer14Component],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'ejercicio10';
}
