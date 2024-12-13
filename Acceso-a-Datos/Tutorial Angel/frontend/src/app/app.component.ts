import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { PruebaComponent } from './components/prueba/prueba.component';
import { DiegoComponent } from './components/diego/diego.component';
import { NavComponent } from './components/nav/nav.component';
import { PrincipalComponent } from './principal/principal.component';
import { SecundarioComponent } from './secundario/secundario.component';


@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, PruebaComponent, DiegoComponent, NavComponent, PrincipalComponent, SecundarioComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'Diego';
}
