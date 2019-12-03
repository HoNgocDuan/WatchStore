package watch.store.mnm.service;

import watch.store.mnm.domain.Role;

public interface IRoleService {
    Role findByName(String name);
}
