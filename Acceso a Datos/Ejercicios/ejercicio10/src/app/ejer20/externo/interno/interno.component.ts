import { CommonModule } from '@angular/common';
import { Component, ElementRef, Input, ViewChild } from '@angular/core';

@Component({
  selector: 'app-interno',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './interno.component.html',
  styleUrl: './interno.component.css'
})
export class InternoComponent {
  @Input() colorRecibido="";

  @ViewChild('inputInterno') inputExterno!: ElementRef;
  colorInterno = 'orange'


}
