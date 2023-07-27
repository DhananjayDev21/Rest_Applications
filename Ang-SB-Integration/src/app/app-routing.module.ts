import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AllComponent } from './Components/all/all.component';
import { DeleteComponent } from './Components/delete/delete.component';
import { CreateComponent } from './Components/create/create.component';
import { UpdateComponent } from './Components/update/update.component';
import { ViewComponent } from './Components/view/view.component';

const routes: Routes = [
  {path:'all',component:AllComponent},
  {path:'update/:id',component:UpdateComponent},
  {path:'create',component:CreateComponent},
  {path:'view/:id',component:ViewComponent},
  {path:'',redirectTo:'all',pathMatch:'full'}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
