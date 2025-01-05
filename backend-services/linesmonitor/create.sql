create table environments (created_at uuid not null, id uuid not null, browser_name varchar(255), browser_version varchar(255), device_type varchar(255), location varchar(255), operating_system varchar(255), primary key (id));
create table measurements (value float(53), measured_at timestamp(6) with time zone not null, metric_id uuid not null, page_id uuid not null, sessionId uuid not null, session_id uuid not null, primary key (sessionId));
create table metrics (created_at timestamp(6) with time zone not null, id uuid not null, name varchar(255) not null, unit varchar(255), primary key (id));
create table pages (created_at timestamp(6) with time zone not null, page_id uuid not null, project_id uuid not null, page_description varchar(255), page_path varchar(255) not null, primary key (page_id));
create table projects (created_at timestamp(6) not null, id uuid not null, description varchar(255), name varchar(255) not null, primary key (id));
create table test_configurations (viewport_height integer, viewport_width integer, created_at uuid not null, id uuid not null, cpu_throttling varchar(255), name varchar(255) not null, network_settings varchar(255), primary key (id));
create table test_runs (environment_id uuid not null, id uuid not null, project_id uuid not null, test_config_id uuid, primary key (id));
alter table if exists measurements add constraint FK52m2pdahabfy21p506eit7r45 foreign key (metric_id) references metrics;
alter table if exists measurements add constraint FKp0s92pdmoioahqbum2d8kka3i foreign key (page_id) references pages;
alter table if exists measurements add constraint FKl9ltma8u0s0isn8trkjayel4d foreign key (session_id) references test_runs;
alter table if exists pages add constraint FK9ao2h9hn2vi6f653wg9wwlinv foreign key (project_id) references projects;
alter table if exists test_runs add constraint FK827cgxh964m3r14un0b42j4r3 foreign key (environment_id) references environments;
alter table if exists test_runs add constraint FKlq9oc3vbq2sw15kruhlhxf56h foreign key (project_id) references projects;
alter table if exists test_runs add constraint FKov4tje997s6j8kf51m2rht0tq foreign key (test_config_id) references test_configurations;
create table environments (created_at uuid not null, id uuid not null, browser_name varchar(255), browser_version varchar(255), device_type varchar(255), location varchar(255), operating_system varchar(255), primary key (id));
create table measurements (value float(53), measured_at timestamp(6) with time zone not null, metric_id uuid not null, page_id uuid not null, sessionId uuid not null, session_id uuid not null, primary key (sessionId));
create table metrics (created_at timestamp(6) with time zone not null, id uuid not null, name varchar(255) not null, unit varchar(255), primary key (id));
create table pages (created_at timestamp(6) with time zone not null, page_id uuid not null, project_id uuid not null, page_description varchar(255), page_path varchar(255) not null, primary key (page_id));
create table projects (created_at timestamp(6) not null, id uuid not null, description varchar(255), name varchar(255) not null, primary key (id));
create table test_configurations (viewport_height integer, viewport_width integer, created_at uuid not null, id uuid not null, cpu_throttling varchar(255), name varchar(255) not null, network_settings varchar(255), primary key (id));
create table test_runs (environment_id uuid not null, id uuid not null, project_id uuid not null, test_config_id uuid, primary key (id));
alter table if exists measurements add constraint FK52m2pdahabfy21p506eit7r45 foreign key (metric_id) references metrics;
alter table if exists measurements add constraint FKp0s92pdmoioahqbum2d8kka3i foreign key (page_id) references pages;
alter table if exists measurements add constraint FKl9ltma8u0s0isn8trkjayel4d foreign key (session_id) references test_runs;
alter table if exists pages add constraint FK9ao2h9hn2vi6f653wg9wwlinv foreign key (project_id) references projects;
alter table if exists test_runs add constraint FK827cgxh964m3r14un0b42j4r3 foreign key (environment_id) references environments;
alter table if exists test_runs add constraint FKlq9oc3vbq2sw15kruhlhxf56h foreign key (project_id) references projects;
alter table if exists test_runs add constraint FKov4tje997s6j8kf51m2rht0tq foreign key (test_config_id) references test_configurations;
create sequence metrics_seq start with 1 increment by 50;
create table environments (created_at uuid not null, id uuid not null, browser_name varchar(255), browser_version varchar(255), device_type varchar(255), location varchar(255), operating_system varchar(255), primary key (id));
create table measurements (value float(53), measured_at timestamp(6) with time zone not null, metric_id bigint not null, page_id uuid not null, sessionId uuid not null, session_id uuid not null, primary key (sessionId));
create table metrics (created_at timestamp(6) with time zone not null, id bigint not null, name varchar(255) not null, unit varchar(255), primary key (id));
create table pages (created_at timestamp(6) with time zone not null, page_id uuid not null, project_id uuid not null, page_description varchar(255), page_path varchar(255) not null, primary key (page_id));
create table projects (created_at timestamp(6) not null, id uuid not null, description varchar(255), name varchar(255) not null, primary key (id));
create table test_configurations (viewport_height integer, viewport_width integer, created_at uuid not null, id uuid not null, cpu_throttling varchar(255), name varchar(255) not null, network_settings varchar(255), primary key (id));
create table test_runs (environment_id uuid not null, id uuid not null, project_id uuid not null, test_config_id uuid, primary key (id));
alter table if exists measurements add constraint FK52m2pdahabfy21p506eit7r45 foreign key (metric_id) references metrics;
alter table if exists measurements add constraint FKp0s92pdmoioahqbum2d8kka3i foreign key (page_id) references pages;
alter table if exists measurements add constraint FKl9ltma8u0s0isn8trkjayel4d foreign key (session_id) references test_runs;
alter table if exists pages add constraint FK9ao2h9hn2vi6f653wg9wwlinv foreign key (project_id) references projects;
alter table if exists test_runs add constraint FK827cgxh964m3r14un0b42j4r3 foreign key (environment_id) references environments;
alter table if exists test_runs add constraint FKlq9oc3vbq2sw15kruhlhxf56h foreign key (project_id) references projects;
alter table if exists test_runs add constraint FKov4tje997s6j8kf51m2rht0tq foreign key (test_config_id) references test_configurations;
create sequence metrics_seq start with 1 increment by 50;
create table environments (created_at uuid not null, id uuid not null, browser_name varchar(255), browser_version varchar(255), device_type varchar(255), location varchar(255), operating_system varchar(255), primary key (id));
create table measurements (value float(53), measured_at timestamp(6) with time zone not null, metric_id bigint not null, page_id uuid not null, sessionId uuid not null, session_id uuid not null, primary key (sessionId));
create table metrics (created_at timestamp(6) with time zone not null, id bigint not null, name varchar(255) not null, unit varchar(255), primary key (id));
create table pages (created_at timestamp(6) with time zone not null, page_id uuid not null, project_id uuid not null, page_description varchar(255), page_path varchar(255) not null, primary key (page_id));
create table projects (created_at timestamp(6) not null, id uuid not null, description varchar(255), name varchar(255) not null, primary key (id));
create table test_configurations (viewport_height integer, viewport_width integer, created_at uuid not null, id uuid not null, cpu_throttling varchar(255), name varchar(255) not null, network_settings varchar(255), primary key (id));
create table test_runs (environment_id uuid not null, id uuid not null, project_id uuid not null, test_config_id uuid, primary key (id));
alter table if exists measurements add constraint FK52m2pdahabfy21p506eit7r45 foreign key (metric_id) references metrics;
alter table if exists measurements add constraint FKp0s92pdmoioahqbum2d8kka3i foreign key (page_id) references pages;
alter table if exists measurements add constraint FKl9ltma8u0s0isn8trkjayel4d foreign key (session_id) references test_runs;
alter table if exists pages add constraint FK9ao2h9hn2vi6f653wg9wwlinv foreign key (project_id) references projects;
alter table if exists test_runs add constraint FK827cgxh964m3r14un0b42j4r3 foreign key (environment_id) references environments;
alter table if exists test_runs add constraint FKlq9oc3vbq2sw15kruhlhxf56h foreign key (project_id) references projects;
alter table if exists test_runs add constraint FKov4tje997s6j8kf51m2rht0tq foreign key (test_config_id) references test_configurations;
create table environments (created_at uuid not null, id uuid not null, browser_name varchar(255), browser_version varchar(255), device_type varchar(255), location varchar(255), operating_system varchar(255), primary key (id));
create table measurements (value float(53), measured_at timestamp(6) with time zone not null, metric_id bigint not null, page_id uuid not null, sessionId uuid not null, session_id uuid not null, primary key (sessionId));
create table metrics (created_at timestamp(6) with time zone not null, id bigint generated by default as identity, name varchar(255) not null, unit varchar(255), primary key (id));
create table pages (created_at timestamp(6) with time zone not null, page_id uuid not null, project_id uuid not null, page_description varchar(255), page_path varchar(255) not null, primary key (page_id));
create table projects (created_at timestamp(6) not null, id uuid not null, description varchar(255), name varchar(255) not null, primary key (id));
create table test_configurations (viewport_height integer, viewport_width integer, created_at uuid not null, id uuid not null, cpu_throttling varchar(255), name varchar(255) not null, network_settings varchar(255), primary key (id));
create table test_runs (environment_id uuid not null, id uuid not null, project_id uuid not null, test_config_id uuid, primary key (id));
alter table if exists measurements add constraint FK52m2pdahabfy21p506eit7r45 foreign key (metric_id) references metrics;
alter table if exists measurements add constraint FKp0s92pdmoioahqbum2d8kka3i foreign key (page_id) references pages;
alter table if exists measurements add constraint FKl9ltma8u0s0isn8trkjayel4d foreign key (session_id) references test_runs;
alter table if exists pages add constraint FK9ao2h9hn2vi6f653wg9wwlinv foreign key (project_id) references projects;
alter table if exists test_runs add constraint FK827cgxh964m3r14un0b42j4r3 foreign key (environment_id) references environments;
alter table if exists test_runs add constraint FKlq9oc3vbq2sw15kruhlhxf56h foreign key (project_id) references projects;
alter table if exists test_runs add constraint FKov4tje997s6j8kf51m2rht0tq foreign key (test_config_id) references test_configurations;
create table environments (created_at uuid not null, id uuid not null, browser_name varchar(255), browser_version varchar(255), device_type varchar(255), location varchar(255), operating_system varchar(255), primary key (id));
create table measurements (value float(53), measured_at timestamp(6) with time zone not null, metric_id bigint not null, page_id uuid not null, sessionId uuid not null, session_id uuid not null, primary key (sessionId));
create table metrics (created_at timestamp(6) with time zone not null, id bigint generated by default as identity, name varchar(255) not null, unit varchar(255), primary key (id));
create table pages (created_at timestamp(6) with time zone not null, page_id uuid not null, project_id uuid not null, page_description varchar(255), page_path varchar(255) not null, primary key (page_id));
create table projects (created_at timestamp(6) not null, id uuid not null, description varchar(255), name varchar(255) not null, primary key (id));
create table test_configurations (viewport_height integer, viewport_width integer, created_at uuid not null, id uuid not null, cpu_throttling varchar(255), name varchar(255) not null, network_settings varchar(255), primary key (id));
create table test_runs (environment_id uuid not null, id uuid not null, project_id uuid not null, test_config_id uuid, primary key (id));
alter table if exists measurements add constraint FK52m2pdahabfy21p506eit7r45 foreign key (metric_id) references metrics;
alter table if exists measurements add constraint FKp0s92pdmoioahqbum2d8kka3i foreign key (page_id) references pages;
alter table if exists measurements add constraint FKl9ltma8u0s0isn8trkjayel4d foreign key (session_id) references test_runs;
alter table if exists pages add constraint FK9ao2h9hn2vi6f653wg9wwlinv foreign key (project_id) references projects;
alter table if exists test_runs add constraint FK827cgxh964m3r14un0b42j4r3 foreign key (environment_id) references environments;
alter table if exists test_runs add constraint FKlq9oc3vbq2sw15kruhlhxf56h foreign key (project_id) references projects;
alter table if exists test_runs add constraint FKov4tje997s6j8kf51m2rht0tq foreign key (test_config_id) references test_configurations;
create table environments (created_at uuid not null, id uuid not null, browser_name varchar(255), browser_version varchar(255), device_type varchar(255), location varchar(255), operating_system varchar(255), primary key (id));
create table measurements (value float(53), measured_at timestamp(6) with time zone not null, metric_id bigint not null, page_id uuid not null, sessionId uuid not null, session_id uuid not null, primary key (sessionId));
create table metrics (created_at timestamp(6) with time zone not null, id bigint generated by default as identity, name varchar(255) not null, unit varchar(255), primary key (id));
create table pages (created_at timestamp(6) with time zone not null, page_id uuid not null, project_id uuid not null, page_description varchar(255), page_path varchar(255) not null, primary key (page_id));
create table projects (created_at timestamp(6) not null, id uuid not null, description varchar(255), name varchar(255) not null, primary key (id));
create table test_configurations (viewport_height integer, viewport_width integer, created_at uuid not null, id uuid not null, cpu_throttling varchar(255), name varchar(255) not null, network_settings varchar(255), primary key (id));
create table test_runs (environment_id uuid not null, id uuid not null, project_id uuid not null, test_config_id uuid, primary key (id));
alter table if exists measurements add constraint FK52m2pdahabfy21p506eit7r45 foreign key (metric_id) references metrics;
alter table if exists measurements add constraint FKp0s92pdmoioahqbum2d8kka3i foreign key (page_id) references pages;
alter table if exists measurements add constraint FKl9ltma8u0s0isn8trkjayel4d foreign key (session_id) references test_runs;
alter table if exists pages add constraint FK9ao2h9hn2vi6f653wg9wwlinv foreign key (project_id) references projects;
alter table if exists test_runs add constraint FK827cgxh964m3r14un0b42j4r3 foreign key (environment_id) references environments;
alter table if exists test_runs add constraint FKlq9oc3vbq2sw15kruhlhxf56h foreign key (project_id) references projects;
alter table if exists test_runs add constraint FKov4tje997s6j8kf51m2rht0tq foreign key (test_config_id) references test_configurations;
create table environments (created_at uuid not null, id uuid not null, browser_name varchar(255), browser_version varchar(255), device_type varchar(255), location varchar(255), operating_system varchar(255), primary key (id));
create table measurements (value float(53), measured_at timestamp(6) with time zone not null, metric_id bigint not null, page_id uuid not null, sessionId uuid not null, session_id uuid not null, primary key (sessionId));
create table metrics (created_at timestamp(6) with time zone not null, id bigint generated by default as identity, name varchar(255) not null, unit varchar(255), primary key (id));
create table pages (created_at timestamp(6) with time zone not null, page_id uuid not null, project_id uuid not null, page_description varchar(255), page_path varchar(255) not null, primary key (page_id));
create table projects (created_at timestamp(6) not null, id uuid not null, description varchar(255), name varchar(255) not null, primary key (id));
create table test_configurations (viewport_height integer, viewport_width integer, created_at uuid not null, id uuid not null, cpu_throttling varchar(255), name varchar(255) not null, network_settings varchar(255), primary key (id));
create table test_runs (environment_id uuid not null, id uuid not null, project_id uuid not null, test_config_id uuid, primary key (id));
alter table if exists measurements add constraint FK52m2pdahabfy21p506eit7r45 foreign key (metric_id) references metrics;
alter table if exists measurements add constraint FKp0s92pdmoioahqbum2d8kka3i foreign key (page_id) references pages;
alter table if exists measurements add constraint FKl9ltma8u0s0isn8trkjayel4d foreign key (session_id) references test_runs;
alter table if exists pages add constraint FK9ao2h9hn2vi6f653wg9wwlinv foreign key (project_id) references projects;
alter table if exists test_runs add constraint FK827cgxh964m3r14un0b42j4r3 foreign key (environment_id) references environments;
alter table if exists test_runs add constraint FKlq9oc3vbq2sw15kruhlhxf56h foreign key (project_id) references projects;
alter table if exists test_runs add constraint FKov4tje997s6j8kf51m2rht0tq foreign key (test_config_id) references test_configurations;
create sequence metrics_seq start with 1 increment by 50;
create table environments (created_at uuid not null, id uuid not null, browser_name varchar(255), browser_version varchar(255), device_type varchar(255), location varchar(255), operating_system varchar(255), primary key (id));
create table measurements (value float(53), measured_at timestamp(6) with time zone not null, metric_id bigint not null, page_id uuid not null, sessionId uuid not null, session_id uuid not null, primary key (sessionId));
create table metrics (created_at timestamp(6) with time zone not null, id bigint not null, name varchar(255) not null, unit varchar(255), primary key (id));
create table pages (created_at timestamp(6) with time zone not null, page_id uuid not null, project_id uuid not null, page_description varchar(255), page_path varchar(255) not null, primary key (page_id));
create table projects (created_at timestamp(6) not null, id uuid not null, description varchar(255), name varchar(255) not null, primary key (id));
create table test_configurations (viewport_height integer, viewport_width integer, created_at uuid not null, id uuid not null, cpu_throttling varchar(255), name varchar(255) not null, network_settings varchar(255), primary key (id));
create table test_runs (environment_id uuid not null, id uuid not null, project_id uuid not null, test_config_id uuid, primary key (id));
alter table if exists measurements add constraint FK52m2pdahabfy21p506eit7r45 foreign key (metric_id) references metrics;
alter table if exists measurements add constraint FKp0s92pdmoioahqbum2d8kka3i foreign key (page_id) references pages;
alter table if exists measurements add constraint FKl9ltma8u0s0isn8trkjayel4d foreign key (session_id) references test_runs;
alter table if exists pages add constraint FK9ao2h9hn2vi6f653wg9wwlinv foreign key (project_id) references projects;
alter table if exists test_runs add constraint FK827cgxh964m3r14un0b42j4r3 foreign key (environment_id) references environments;
alter table if exists test_runs add constraint FKlq9oc3vbq2sw15kruhlhxf56h foreign key (project_id) references projects;
alter table if exists test_runs add constraint FKov4tje997s6j8kf51m2rht0tq foreign key (test_config_id) references test_configurations;
create table environments (created_at uuid not null, id uuid not null, browser_name varchar(255), browser_version varchar(255), device_type varchar(255), location varchar(255), operating_system varchar(255), primary key (id));
create table measurements (value float(53), measured_at timestamp(6) with time zone not null, metric_id bigint not null, page_id uuid not null, sessionId uuid not null, session_id uuid not null, primary key (sessionId));
create table metrics (created_at timestamp(6) with time zone not null, id bigint not null, name varchar(255) not null, unit varchar(255), primary key (id));
create table pages (created_at timestamp(6) with time zone not null, page_id uuid not null, project_id uuid not null, page_description varchar(255), page_path varchar(255) not null, primary key (page_id));
create table projects (created_at timestamp(6) not null, id uuid not null, description varchar(255), name varchar(255) not null, primary key (id));
create table test_configurations (viewport_height integer, viewport_width integer, created_at uuid not null, id uuid not null, cpu_throttling varchar(255), name varchar(255) not null, network_settings varchar(255), primary key (id));
create table test_runs (environment_id uuid not null, id uuid not null, project_id uuid not null, test_config_id uuid, primary key (id));
alter table if exists measurements add constraint FK52m2pdahabfy21p506eit7r45 foreign key (metric_id) references metrics;
alter table if exists measurements add constraint FKp0s92pdmoioahqbum2d8kka3i foreign key (page_id) references pages;
alter table if exists measurements add constraint FKl9ltma8u0s0isn8trkjayel4d foreign key (session_id) references test_runs;
alter table if exists pages add constraint FK9ao2h9hn2vi6f653wg9wwlinv foreign key (project_id) references projects;
alter table if exists test_runs add constraint FK827cgxh964m3r14un0b42j4r3 foreign key (environment_id) references environments;
alter table if exists test_runs add constraint FKlq9oc3vbq2sw15kruhlhxf56h foreign key (project_id) references projects;
alter table if exists test_runs add constraint FKov4tje997s6j8kf51m2rht0tq foreign key (test_config_id) references test_configurations;
create table environments (created_at uuid not null, id uuid not null, browser_name varchar(255), browser_version varchar(255), device_type varchar(255), location varchar(255), operating_system varchar(255), primary key (id));
create table measurements (value float(53), measured_at timestamp(6) with time zone not null, metric_id uuid not null, page_id uuid not null, sessionId uuid not null, session_id uuid not null, primary key (sessionId));
create table metrics (created_at timestamp(6) with time zone not null, id uuid not null, name varchar(255) not null, unit varchar(255), primary key (id));
create table pages (created_at timestamp(6) with time zone not null, page_id uuid not null, project_id uuid not null, page_description varchar(255), page_path varchar(255) not null, primary key (page_id));
create table projects (created_at timestamp(6) not null, id uuid not null, description varchar(255), name varchar(255) not null, primary key (id));
create table test_configurations (viewport_height integer, viewport_width integer, created_at uuid not null, id uuid not null, cpu_throttling varchar(255), name varchar(255) not null, network_settings varchar(255), primary key (id));
create table test_runs (environment_id uuid not null, id uuid not null, project_id uuid not null, test_config_id uuid, primary key (id));
alter table if exists measurements add constraint FK52m2pdahabfy21p506eit7r45 foreign key (metric_id) references metrics;
alter table if exists measurements add constraint FKp0s92pdmoioahqbum2d8kka3i foreign key (page_id) references pages;
alter table if exists measurements add constraint FKl9ltma8u0s0isn8trkjayel4d foreign key (session_id) references test_runs;
alter table if exists pages add constraint FK9ao2h9hn2vi6f653wg9wwlinv foreign key (project_id) references projects;
alter table if exists test_runs add constraint FK827cgxh964m3r14un0b42j4r3 foreign key (environment_id) references environments;
alter table if exists test_runs add constraint FKlq9oc3vbq2sw15kruhlhxf56h foreign key (project_id) references projects;
alter table if exists test_runs add constraint FKov4tje997s6j8kf51m2rht0tq foreign key (test_config_id) references test_configurations;
