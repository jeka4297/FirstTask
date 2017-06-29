/**
 * Created by qbolt42 on 28.06.17.
 */
public interface IFunctionalAtOneArg <T extends IFunctionOfOneDoubleArg >{
    public  double calcFunctional(T fun) throws OversteppingException, WrongBoardsOfIntegrationException;
}
