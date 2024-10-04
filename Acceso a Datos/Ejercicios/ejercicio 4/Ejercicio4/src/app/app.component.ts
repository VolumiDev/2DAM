import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { Ejer4Component } from './ejer4/ejer4.component';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, Ejer4Component],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'Ejercicio4';
}
