import { CommonModule } from '@angular/common';
import { Component, Input } from '@angular/core';

@Component({
  selector: 'app-izq',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './izq.component.html',
  styleUrl: './izq.component.css'
})
export class IzqComponent {
  @Input() recibirCadena: string[] = [];
}
