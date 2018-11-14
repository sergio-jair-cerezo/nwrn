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
    
    private let mockData:Dictionary = ["scores":
        [
            ["name":"Alex", "value":"42"],
            ["name":"Joel", "value":"10"]
        ]
    ]
    
    override func viewDidLoad() {
        super.viewDidLoad()
        
        self.navigationItem.title = "Swift to RN"
        
        self.navigationItem.leftBarButtonItem = UIBarButtonItem(
            image: UIImage(named: "bars-solid"), style: .plain,
            target: self, action: #selector(menuButtonTapped(sender:)))
        
        self.textView.text = self.mockData.prettyPrintedJSON
    }
    
    @objc func menuButtonTapped(sender: UIBarButtonItem) {
        self.slideMenuController()?.openLeft()
    }
    
    @IBAction func goToRNTapped(_ sender: Any) {
        var dictToPass: [String: Any] = self.mockData
        
        if let data = self.textView.text.data(using: String.Encoding.utf8) {
            do {
                let json = try JSONSerialization.jsonObject(with: data, options: .mutableContainers) as? [String:Any]
                dictToPass = json ?? [:]
            } catch {
                print("Something went wrong, default data to pass will be used instead")
            }
        }
        
        let rnVC = RNEmbededHelper.getRNVC(initialProperties: dictToPass as [NSObject : AnyObject])
        rnVC.title = "High Scores"
        self.navigationController?.pushViewController(rnVC, animated: true)
    }
    
}
