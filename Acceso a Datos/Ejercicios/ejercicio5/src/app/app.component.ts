import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { Ejer5Component } from './ejer5/ejer5.component';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, Ejer5Component],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'ejercicio5';
}
