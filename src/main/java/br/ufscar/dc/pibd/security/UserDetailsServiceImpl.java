package br.ufscar.dc.pibd.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import br.ufscar.dc.pibd.classes.Pessoa;
import br.ufscar.dc.pibd.dao.IPessoaDAO;



public class UserDetailsServiceImpl implements UserDetailsService{
    @Autowired
    private IPessoaDAO pessoaDao;
    
     
    @Override
    public UserDetails loadUserByUsername(String email)
            throws UsernameNotFoundException{
        Pessoa pessoa = pessoaDao.getPessoaByEmail(email);
         
        if (pessoa == null) {
            throw new UsernameNotFoundException("Could not find pessoa");
        }
         
        return new UserAccount(pessoa);
    }
}
