export class Cours {
  constructor(
  public  id: number= 0,
  public nomFichier: string='',
  public  typeFichier: string='',
  public  donneesFichier?: Blob
  ){}
  }
