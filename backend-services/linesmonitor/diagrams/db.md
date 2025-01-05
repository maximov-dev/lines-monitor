@startuml

entity "projects" as projects {
* project_id : PK
  --
  project_name : VARCHAR(255)
  description : TEXT
  created_at : TIMESTAMP
  }

entity "environments" as env {
* environment_id : PK
  --
  device_type : VARCHAR(100)
  operating_system : VARCHAR(100)
  browser_name : VARCHAR(100)
  browser_version : VARCHAR(50)
  location : VARCHAR(255)
  created_at : TIMESTAMP
  }

entity "test_configurations" as config {
* test_config_id : PK
  --
  config_name : VARCHAR(255)
  network_settings : VARCHAR(255)
  cpu_throttling : VARCHAR(255)
  viewport_width : INT
  viewport_height : INT
  created_at : TIMESTAMP
  }

entity "pages" as pages {
* page_id : PK
  --
  project_id : FK -> projects.project_id
  page_path : VARCHAR(500)
  page_description : TEXT
  created_at : TIMESTAMP
  }

entity "test_runs" as runs {
* test_run_id : PK
  --
  project_id : FK -> projects.project_id
  environment_id : FK -> env.environment_id
  test_config_id : FK -> config.test_config_id
  run_timestamp : TIMESTAMP
  run_description : TEXT
  }

entity "metrics" as metrics {
* metric_id : PK
  --
  metric_name : VARCHAR(255)
  metric_unit : VARCHAR(50)
  metric_desc : TEXT
  created_at : TIMESTAMP
  }

entity "measurement_results" as results {
* measurement_id : PK
  --
  test_run_id : FK -> runs.test_run_id
  page_id : FK -> pages.page_id
  metric_id : FK -> metrics.metric_id
  metric_value : DECIMAL(12,4)
  measured_at : TIMESTAMP
  }

'
' Relationships
'
projects ||--|{ pages : "1 - ∞"
projects ||--|{ runs : "1 - ∞"
env ||--|{ runs : "1 - ∞"
config ||--|{ runs : "1 - ∞"
runs ||--|{ results : "1 - ∞"
pages ||--|{ results : "1 - ∞"
metrics ||--|{ results : "1 - ∞"

@enduml