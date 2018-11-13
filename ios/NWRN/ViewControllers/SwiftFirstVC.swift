//
//  SwiftMainVC.swift
//  NWRN
//
//  Created by Sergio Jair Cerezo Vallejo on 11/12/18.
//  Copyright © 2018 Sergio Jair Cerezo Vallejo. All rights reserved.
//

import Foundation
import UIKit

class SwiftFirstVC: UIViewController {
    
    override func viewDidLoad() {
        super.viewDidLoad()
        
        self.navigationItem.title = "First VC"
        
        self.navigationItem.leftBarButtonItem = UIBarButtonItem(image: UIImage(named: "bars-solid"), style: .plain,
                                                                target: self, action: #selector(menuButtonTapped(sender:)))
    }
    
    @objc func menuButtonTapped(sender: UIBarButtonItem) {
        self.slideMenuController()?.openLeft()
    }
    
    @IBAction func goToSecondVCTapped(_ sender: Any) {
        let secondVC = SwiftSecondVC(nibName: "SwiftSecondVC", bundle: nil) as SwiftSecondVC
        self.navigationController?.pushViewController(secondVC, animated: true)
    }
    
}
