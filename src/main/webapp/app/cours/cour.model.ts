export class Cour {
  constructor(
  public  id: number= 0,
  public nomFichier: string='',
  public  typeFichier: string='',
  public  donneesFichier?: Blob 
  ){}
  }