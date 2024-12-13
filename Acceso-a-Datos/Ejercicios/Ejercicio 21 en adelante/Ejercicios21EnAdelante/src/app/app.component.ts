import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { C1Component } from "./22/c1/c1.component";
import { PadreComponent } from './21/padre/padre.component';
import { E23PadreComponent } from "./23/e23-padre/e23-padre.component";
import { E24C1Component } from "./24/e24-c1/e24-c1.component";
import { E25C1Component } from "./25/e25-c1/e25-c1.component";
import { E26C1Component } from "./26/e26-c1/e26-c1.component";
import { E27C1Component } from "./27/e27-c1/e27-c1.component";

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, PadreComponent, C1Component, E23PadreComponent, E24C1Component, E25C1Component, E26C1Component, E27C1Component],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'Ejercicios21EnAdelante';
}
