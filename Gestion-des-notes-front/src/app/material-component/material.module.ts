import 'hammerjs';
import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import { HttpClientModule } from '@angular/common/http';
import { CommonModule } from '@angular/common';

import { DemoMaterialModule } from '../demo-material-module';
import { CdkTableModule } from '@angular/cdk/table';

import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { FlexLayoutModule } from '@angular/flex-layout';

import { MaterialRoutes } from './material.routing';


import { ExpansionComponent } from './expansion/expansion.component';
import { GestionDesEtudiantsComponent } from './gestion-des-etudiants/gestion-des-etudiants.component';
import { GestionDesMatieresComponent } from './gestion-des-matieres/gestion-des-matieres.component';
import { GestionDesAdministrateursComponent } from './gestion-des-administrateurs/gestion-des-administrateurs.component';
import { LoginComponent } from '../login/login.component';
import { SupprimerEtudiantComponent } from './gestion-des-etudiants/supprimer-etudiant/supprimer-etudiant.component';
import { ToastrModule } from 'ngx-toastr';
import { AjouteretudiantComponent } from './gestion-des-etudiants/ajouteretudiant/ajouteretudiant.component';
import { AjouterutilisateurComponent } from './gestion-des-administrateurs/ajouterutilisateur/ajouterutilisateur.component';
import { NotesComponent } from './notes/notes.component';
import { ConfigurationsComponent } from './configurations/configurations.component';
import { AjouterconfigurationComponent } from './configurations/ajouterconfiguration/ajouterconfiguration.component';
import { NoteuniteComponent } from './notes/noteunite/noteunite.component';
import { NotematiereComponent } from './notes/notematiere/notematiere.component';
import { RattrapageComponent } from './rattrapage/rattrapage.component';
import { AdmissionComponent } from './admission/admission.component';


@NgModule({
  imports: [
    CommonModule,
    RouterModule.forChild(MaterialRoutes),
    DemoMaterialModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule,
    FlexLayoutModule,
    CdkTableModule,

  ],
  providers: [],
  entryComponents: [],
  declarations: [
    ExpansionComponent,
    GestionDesEtudiantsComponent,
    GestionDesMatieresComponent,
    GestionDesAdministrateursComponent,
    SupprimerEtudiantComponent,
    AjouteretudiantComponent,
    AjouterutilisateurComponent,
    NotesComponent,
    ConfigurationsComponent,
    AjouterconfigurationComponent,
    NoteuniteComponent,
    NotematiereComponent,
    RattrapageComponent,
    AdmissionComponent
   
  
  ]
})
export class MaterialComponentsModule {}
