import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-ejer12',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './ejer12.component.html',
  styleUrl: './ejer12.component.css'
})
export class Ejer12Component {
color: string = 'red'

cambiacolor():void {
  
}
}
