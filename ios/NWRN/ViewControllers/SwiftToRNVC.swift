//
//  SwiftToReactVC.swift
//  NWRN
//
//  Created by Sergio Jair Cerezo Vallejo on 11/12/18.
//  Copyright © 2018 Sergio Jair Cerezo Vallejo. All rights reserved.
//

import Foundation
import UIKit

class SwiftToRNVC: UIViewController {
    
    @IBOutlet weak var textView: UITextView!
    
    override func viewDidLoad() {
        super.viewDidLoad()
        
        self.navigationItem.title = "Swift to RN"
        
        self.navigationItem.leftBarButtonItem = UIBarButtonItem(
            image: UIImage(named: "bars-solid"), style: .plain,
            target: self, action: #selector(menuButtonTapped(sender:)))
    }
    
    @objc func menuButtonTapped(sender: UIBarButtonItem) {
        self.slideMenuController()?.openLeft()
    }
    
    @IBAction func goToRNTapped(_ sender: Any) {
        let mockData:NSDictionary = ["scores":
            [
                ["name":"Alex", "value":"42"],
                ["name":"Joel", "value":"10"]
            ]
        ]
        
        let rnVC = RNEmbededHelper.getRNVC(initialProperties: mockData as [NSObject : AnyObject])
        self.navigationController?.pushViewController(rnVC, animated: true)
    }
    
}
