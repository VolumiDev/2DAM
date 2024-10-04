import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { Ejer6Component } from './ejer6/ejer6.component';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, Ejer6Component],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'ejercicio6';
}
