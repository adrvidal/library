package com.example.library.service;

import com.example.library.model.Loan;
import com.example.library.repository.LoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LoanService {

    @Autowired
    private LoanRepository loanRepository;

    public Loan createLoan(Loan loan) {
        return loanRepository.save(loan);
    }

    public List<Loan> getAllLoans() {
        return loanRepository.findAll();
    }

    public Optional<Loan> getLoanById(Long id) {
        return loanRepository.findById(id);
    }

    public List<Loan> getLoansByUserId(Long userId) {
        return loanRepository.findByUserId(userId);
    }

    public Loan updateLoan(Long id, Loan loanDetails) {
        Loan loan = loanRepository.findById(id).orElseThrow(() -> new RuntimeException("Loan not found"));

        loan.setReturnDate(loanDetails.getReturnDate());

        return loanRepository.save(loan);
    }

    public void deleteLoan(Long id) {
        loanRepository.deleteById(id);
    }
}
