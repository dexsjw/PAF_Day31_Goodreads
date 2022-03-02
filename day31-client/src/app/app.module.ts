import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { RouterModule, Routes } from '@angular/router';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

import { AppComponent } from './app.component';
import { MainComponent } from './main/main.component';
import { DisplayComponent } from './display/display.component';
import { GoodreadService } from './goodread.service';

const appRoutes: Routes = [
  { path: '', component: MainComponent },
  { path: 'display', component: DisplayComponent },
  { path: '**', redirectTo: '/', pathMatch: 'full' }
]

@NgModule({
  declarations: [
    AppComponent,
    MainComponent,
    DisplayComponent
  ],
  imports: [
    BrowserModule,
    RouterModule.forRoot(appRoutes),
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule
  ],
  providers: [GoodreadService],
  bootstrap: [AppComponent]
})
export class AppModule { }
