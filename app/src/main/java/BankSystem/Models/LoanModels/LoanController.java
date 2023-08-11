/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BankSystem.Models.LoanModels;

import BankSystem.Models.UserModels.userRepository;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 *
 * @author adel
 */
public class LoanController {
    public static void createLoan(String requesterUserName , LoanModel requestedLoan) throws SQLException{
      requestedLoan.setRequester(userRepository.getUserByUserName(requesterUserName));
      LoanRepository.createLoan(requestedLoan);
    }
    
    public static List<LoanModel> getAllUserLoans(String userName) throws SQLException{
        return LoanRepository.getUserLoans(userName);
    }
    public static List<String> flattenLoans(List<LoanModel> loans){
        List<String>flattedLoans = new ArrayList<>();
        for(int i = 0 ; i <loans.size();i++){
           flattedLoans.add (loans.get(i).getId().toString());
           flattedLoans.add (loans.get(i).getRequester().getUserName());
           flattedLoans.add (loans.get(i).getDate().toString());
           flattedLoans.add (loans.get(i).getType());
           flattedLoans.add (String.valueOf(loans.get(i).getAmount()));
           flattedLoans.add (loans.get(i).getStatus());
        }
        return flattedLoans;
    }
    
    public static LoanModel getLoan(UUID loanId) throws SQLException{
        return LoanRepository.getLoanRequestById(loanId);
    }
    
    public static void updateLoanStatus (String status,UUID loanId) throws SQLException{
        LoanRepository.changeLoanStatus(status, loanId);
    }
}
