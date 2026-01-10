<?php

class Login {

    public function __construct(){}


    /**
    * Handle the login feature
    * @param
    *   $username (string), $password (string)
    *
    * @return 
    *   Boolean
    **/
    public function login($username, $password){
        $loginCreds = $this->getCredentials();

        foreach($loginCreds as $key => $value) {
            if($loginCreds[$key]['user'] == $username && $loginCreds[$key]['password'] == $password) {
                $data['type'] = $loginCreds[$key]['type'];
                $data['result'] = true;

                return $data;
            }
        }
        return false;      
    }

    /**
    * Handle the logout feature by destroying session
    * @param
    *   NONE
    *
    * @return 
    *   Boolean
    **/
    public function logout(){
        unset($_SESSION['user']);
        session_destroy();

        return true;
    }


    /**
    * Read Credentials JSON file to get saved username and password
    * @param
    *   NONE
    *
    * @return 
    *   $data (ARRAY)
    **/
    private function getCredentials() {
        $jsonRead = file_get_contents(CREDENTIALS_FILE);
        $jsonData = json_decode($jsonRead, true);
        
        foreach($jsonData['credentials'] as $key => $value) {           
            $data[$key]['user'] = $jsonData['credentials'][$key]['user'];
            $data[$key]['password'] = $jsonData['credentials'][$key]['password'];
            $data[$key]['type'] = $jsonData['credentials'][$key]['type'];
        }       

        return $data;
    }

    public function show($data) {
        echo "<pre>";
        print_r($data);
        echo "</pre>";
        exit;
    }

} // End Login Class
?>