import { Alunos } from "./alunos"

export interface Diplomas{

    id?:number
    descricao?:string
    linkdiploma?:string
    alunos?: Alunos
}