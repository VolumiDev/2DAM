import { CommonModule } from '@angular/common';
import { Component, Input } from '@angular/core';

@Component({
  selector: 'app-der',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './der.component.html',
  styleUrl: './der.component.css'
})
export class DerComponent {

  @Input() recibirNumeros: number[] = [];
}
