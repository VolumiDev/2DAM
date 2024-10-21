import { CommonModule } from '@angular/common';
import { Component, Input } from '@angular/core';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-der14',
  standalone: true,
  imports: [FormsModule, CommonModule
  ],
  templateUrl: './der14.component.html',
  styleUrl: './der14.component.css'
})
export class Der14Component {
  @Input() recibirVector: string[] = []

}
