import { NgModule } from "@angular/core";
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatSidenavModule } from '@angular/material/sidenav';
import { MatIconModule } from '@angular/material/icon';
import { MatListModule } from '@angular/material/list';
import { MatExpansionModule } from '@angular/material/expansion';
import { MatCardModule } from '@angular/material/card';
import { MatSelectModule } from '@angular/material/select';
import { MatInputModule } from '@angular/material/input';
import { MatRadioModule } from '@angular/material/radio';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatMenuModule } from '@angular/material/menu';
import { MatButtonModule } from '@angular/material/button';
import { MatDialogModule } from '@angular/material/dialog';
import { MatStepperModule } from '@angular/material/stepper';
import { MatDatepickerModule } from '@angular/material/datepicker';
import { MatSlideToggleModule } from '@angular/material/slide-toggle';
import { MatAutocompleteModule } from '@angular/material/autocomplete';
import { MatTableModule } from '@angular/material/table';

@NgModule({
    exports: [MatToolbarModule,
        MatSidenavModule,
        MatIconModule,
        MatListModule,
        MatExpansionModule,
        MatCardModule,
        MatSelectModule,
        MatInputModule,
        MatRadioModule,
        MatFormFieldModule,
        MatMenuModule,
        MatButtonModule,
        MatDialogModule,
        MatStepperModule,
        MatDatepickerModule,
        MatSlideToggleModule,
        MatAutocompleteModule,
        MatTableModule
    ],
    imports: [MatToolbarModule,
        MatSidenavModule,
        MatIconModule,
        MatListModule,
        MatExpansionModule,
        MatCardModule,
        MatSelectModule,
        MatInputModule,
        MatRadioModule,
        MatFormFieldModule,
        MatMenuModule,
        MatButtonModule,
        MatDialogModule,
        MatStepperModule,
        MatDatepickerModule,
        MatSlideToggleModule,
        MatAutocompleteModule,
        MatTableModule
    ]
})

export class MaterialModule { }