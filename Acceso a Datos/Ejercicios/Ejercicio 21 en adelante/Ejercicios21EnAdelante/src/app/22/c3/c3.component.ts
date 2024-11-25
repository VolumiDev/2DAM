import { Component, Input } from '@angular/core';

@Component({
  selector: 'app-c3',
  standalone: true,
  imports: [],
  templateUrl: './c3.component.html',
  styleUrl: './c3.component.css'
})
export class C3Component {
  title: string = 'C3';
  @Input()
  isPar!: boolean
}
