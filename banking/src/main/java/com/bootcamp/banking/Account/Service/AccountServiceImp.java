package com.bootcamp.banking.Account.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.bootcamp.banking.Account.Model.document.Account;
import com.bootcamp.banking.Account.Model.repository.AccountRepository;
import com.bootcamp.banking.Account.Model.service.AccountService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Validated
@Service
public class AccountServiceImp implements AccountService {

	@Autowired
	private AccountRepository accountRepository;

	@Override
	public Flux<Account> getAll() throws Exception {
		return this.accountRepository.findAll();
	}

	@Override
	public Mono<Account> save(Account account) {
		return this.accountRepository.save(account);
	}

	@Override
	public Mono<Account> findById(String id) {
		return this.accountRepository.findById(id);
	}

	@Override
	public Mono<Boolean> existsById(String id) {
		return this.accountRepository.existsById(id);
	}

	@Override
	public Mono<Void> deleteById(String id) throws Exception {
		return this.accountRepository.deleteById(id);
	}


	
	@Override
	public Mono<Account> update(String id,Account account) {
	    return this.accountRepository.findById(id)
	            .flatMap(existingAccount-> accountRepository.save(account));
	}

}