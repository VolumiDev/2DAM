import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { Ejer9Component } from './ejer9/ejer9.component';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, Ejer9Component],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'ejercicio9';
}
