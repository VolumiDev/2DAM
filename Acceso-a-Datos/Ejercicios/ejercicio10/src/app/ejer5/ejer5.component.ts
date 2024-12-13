import { Component } from '@angular/core';
import { Persona } from '../models/persona';

@Component({
  selector: 'app-ejer5',
  standalone: true,
  imports: [],
  templateUrl: './ejer5.component.html',
  styleUrl: './ejer5.component.css'
})
export class Ejer5Component {
  p1: Persona;
  p2: Persona;
  menApellido: string = "";
  menEdad: string = "";
  constructor() {
    this.p1 = new Persona("Diego", "Martin", 35);
    this.p2 = new Persona("David", "Martinez", 35);
  }

  comparar(): void {
    if (this.p1.apellido === this.p2.apellido) {
      this.menApellido = "Los apellidos son iguales"
    }else{
      this.menApellido = "Los apellidos son distintos"
    }
    if (this.p1.edad === this.p2.edad) {
      this.menEdad = "Las edades son iguales"
    }else{
      this.menEdad = "Las edades son distintas"
    }
    console.log(this.menApellido)
    console.log(this.menEdad)
  }

  ngOnInit() { }

}
