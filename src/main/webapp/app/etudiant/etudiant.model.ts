export class Etudiant {
  constructor(
    public id: number = 0,
    public nom: string = '',
    public prenom: string = '',
    public adresse: string = '',
    public email: string = '',
    public telephone: string = ''
  ) {}
}
