export class QuestionOp {
  constructor(
  public opId: string = '',
    public OptArr = [] ,
    public userEmail = localStorage.getItem('userEmail')
  )
  
  {}
}
