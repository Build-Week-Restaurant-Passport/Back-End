package com.lambda.restaurant.service;

import com.lambda.restaurant.exceptions.ResourceNotFoundException;
import com.lambda.restaurant.model.NewUse;
import com.lambda.restaurant.repo.newUseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.beanvalidation.SpringValidatorAdapter;

import java.util.ArrayList;
import java.util.List;

@Service(value = "useSer")
public class newuseSerImpl implements newuseSer{


        @Autowired
        private newUseRepo userrepo;



        @Transactional
        public NewUse findUserById(long id) throws ResourceNotFoundException
        {
            return userrepo.findById(id).orElseThrow(() -> new ResourceNotFoundException(Long.toString(id)));
        }

        public List<NewUse> findAll()
        {
            List<NewUse> list = new ArrayList<>();
            userrepo.findAll().iterator().forEachRemaining(list::add);
            return list;
        }

        @Override
        public void delete(long id)
        {
            if (userrepo.findById(id).isPresent())
            {
                userrepo.deleteById(id);
            } else
            {
                throw new ResourceNotFoundException(Long.toString(id));
            }
        }
//    private String userna;
        @Transactional
        @Override
        public NewUse save(NewUse newUser){

            NewUse user = new NewUse();
            user.setEmail(newUser.getEmail());
            user.setPassword(newUser.getPassword());

            return userrepo.save(user);

        }


//        @Transactional
//        @Override
//        public NewUse update(NewUse newuser, long id)
//        {
//            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//            NewUse currentUser = userrepos.findByUsername(authentication.getName());
//
//            if (currentUser != null)
//            {
//                if (id == currentUser.getUserid())
//                {
//                    if (newuser.getUsername() != null)
//                    {
//                        currentUser.setUsername(user.getUsername());
//                    }
//
//                    if (user.getPassword() != null)
//                    {
//                        currentUser.setPasswordNoEncrypt(user.getPassword());
//                    }
//
//
//                    return userrepos.save(currentUser);
//                } else
//                {
//                    throw new ResourceNotFoundException(id + " Not current user");
//                }
//            } else
//            {
//                throw new ResourceNotFoundException(authentication.getName());
//            }
//
//        }
//    }
}
