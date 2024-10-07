import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { Ejer7Component } from './ejer7/ejer7.component';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, Ejer7Component],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'ejercicio7';
}
