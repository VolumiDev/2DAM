import { Component, OnInit } from '@angular/core';
import { SecundarioComponent } from '../secundario/secundario.component';
import { Empleado } from '../../models/empleados';

@Component({
  selector: 'app-principal',
  standalone: true,
  imports: [SecundarioComponent],
  templateUrl: './principal.component.html',
  styleUrl: './principal.component.css'
})
export class PrincipalComponent {

  public empleado = new Empleado('Diego', 35);
  ngOnInit(){
    console.log(this.empleado.nombre)
  }
}
