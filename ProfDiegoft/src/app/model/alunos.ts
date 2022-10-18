import { Diplomas } from './diplomas';
import { Boletos } from './boletos';
import { Usuario } from './usuarios';

export interface Alunos{

     id?: number
     nome?: string
     nascimento?: Date
     observacao?: string
     imguser?: string
     usuario?: Usuario
     boletos?: Boletos[]
     diplomas?:Diplomas[]
}