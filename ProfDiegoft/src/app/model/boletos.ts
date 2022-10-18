import { Alunos } from './alunos';
export interface Boletos{
    
    id?:number
    codigo?:string
    vencimento?:Date
    linkboleto?:string
    alunos?: Alunos
    
}