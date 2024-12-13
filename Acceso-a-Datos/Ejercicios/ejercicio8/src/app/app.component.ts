import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { Ejer8Component } from './ejer8/ejer8.component';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, Ejer8Component],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'ejercicio8';
}
